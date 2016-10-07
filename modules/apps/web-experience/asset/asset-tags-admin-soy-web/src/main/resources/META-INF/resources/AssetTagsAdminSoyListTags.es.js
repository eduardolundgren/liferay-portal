import Component from 'metal-component';
import Soy from 'metal-soy';

import LexiconBreadcrumbs from 'lexicon-breadcrumbs';
import LexiconButton from 'lexicon-button';
//import AddMenu from 'liferay-metal-addMenu/src/AddMenu';
//import SearchContainer from 'liferay-metal-searchContainer/src/SearchContainer';
//import SearchContainerIcon from 'liferay-metal-searchContainer/src/SearchContainerIcon.soy';

import templates from './AssetTagsAdminSoyListTags.soy';

class AssetTagsAdmimSoyListTags extends Component {
	constructor(opt_config, opt_parentElement) {
		console.log('constructor');

		super(opt_config, opt_parentElement);
	}

	attached() {
		console.log('attached');
	}
}

// Register component
Soy.register(AssetTagsAdmimSoyListTags, templates);

export default AssetTagsAdmimSoyListTags;