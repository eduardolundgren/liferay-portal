'use strict';

var isparta = require('isparta');
var properties = require('./test/src/properties.js');

var defaultConfig = {
	babelPreprocessor: {
		options: {
			sourceMap: 'both'
		}
	},

	browsers: ['Chrome'],

	coverageReporter: {
		dir: 'test/coverage',
		instrumenters: {
			'isparta': isparta
		},
		instrumenter: {
			'**/*.js': 'isparta'
		},
		reporters: [
			{
				type: 'html'
			},
			{
				type: 'json',
				file: 'coverage.json'
			},
			{
				subdir: 'lcov',
				type: 'lcov'
			},
			{
				"type": "text-summary"
			}
		]
	},

	frameworks: ['chai', 'mocha', 'sinon', 'source-map-support'],

    junitReporter: {
		outputFile: 'test/junit/test-results.xml'
    },

	preprocessors: {
		'src/META-INF/resources/html/js/liferay/*.js': ['coverage'],
		// 'test/src/*/main.js': ['babel', 'commonjs']
	},

	reporters: ['coverage', 'progress', 'junit'],

	singleRun: true
};

defaultConfig.files = [
	'test/src/mock_base.js',
	{
		included: false,
		pattern: 'test/src/mock_available_languages.js',
		served: true
	},
	{
		included: false,
		pattern: 'test/src/mock_language.js',
		served: true
	}
];

properties.read(
	'portal-impl/src/portal.properties',
	function(data) {
		var props = data[0];

		var bareboneFiles = props['javascript.barebone.files'].split(',');

		bareboneFiles.forEach(
			function(file) {
				var filePath = [file];

				if ((file.indexOf('aui') === 0) || (file.indexOf('bootstrap') === 0)) {
					filePath.unshift('tmp/META-INF/resources/html/js');
				}
				else {
					filePath.unshift('src/META-INF/resources/html/js');
				}

				defaultConfig.files.push(
					{
						included: true,
						pattern: filePath.join('/'),
						served: true
					}
				);

				if (file === 'liferay/modules.js') {
					defaultConfig.files.push('test/src/mock_modules.js');
				}
			}
		);

		defaultConfig.files = defaultConfig.files.concat(
			[
				{
					included: false,
					pattern: 'tmp/META-INF/resources/html/js/aui/**/*.css',
					served: true
				},

				{
					included: false,
					pattern: 'tmp/META-INF/resources/html/js/aui/**/*.js',
					served: true
				},

				{
					included: false,
					pattern: 'src/META-INF/resources/html/js/liferay/*.js',
					served: true
				},

				{
					included: false,
					pattern: 'test/src/*/assets/*',
					served: true
				},

				{
					included: true,
					pattern: 'test/src/*/main.js',
					served: true
				}
			]
		);

		module.exports = function(config) {
			config.set(defaultConfig);
		};
	}
);