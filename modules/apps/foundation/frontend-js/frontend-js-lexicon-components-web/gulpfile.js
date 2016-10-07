'use strict';

var gulp = require('gulp');
var metal = require('gulp-metal');
var runSequence = require('run-sequence');
var packageJson = require('./package.json');

var components = Object.keys(packageJson.dependencies).filter(function(key) {
	return key.startsWith('lexicon-');
});

var getComponentPaths = function(folder, ext) {
	ext = ext || '*.js';
	return components.map(function(name) {
		return 'node_modules/' + name + '/' + folder + '/**/' + ext;
	});
};

metal.registerTasks({
	buildAmdJqueryDest: 'classes/META-INF/resources',
	buildSrc: getComponentPaths('src'),
	soyDeps: ['node_modules/*lexicon*/**/*.soy', 'node_modules/*metal*/**/*.soy']
});

gulp.task('soy:copy', function() {
	return gulp.src('node_modules/lexicon-*/src/**/*.soy')
		.pipe(gulp.dest('classes/META-INF/resources'));
});

gulp.task('bundle', function(done) {
	runSequence(
		['build:amd:jquery', 'soy:copy'],
		done
	);
});
