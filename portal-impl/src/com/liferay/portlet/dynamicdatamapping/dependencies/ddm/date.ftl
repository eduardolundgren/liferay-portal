<#include "../init.ftl">

<#if !(fields?? && fields.get(fieldName)??) && (fieldRawValue == "")>
	<#assign fieldRawValue = predefinedValue?date("MM/dd/yyyy")>
</#if>

<#if (fieldRawValue?is_date)>
	<#assign fieldDateValue = fieldRawValue>
<#else>
	<#assign fieldDateValue = dateUtil.newDate()>
</#if>

<@aui["field-wrapper"] helpMessage=fieldStructure.tip label=label required=required>
	<@liferay_ui["input-date"]
		cssClass=cssClass
		dayParam="${namespacedFieldName}Day"
		dayValue=fieldDateValue?string("dd")?number
		disabled=false
		helpMessage=fieldStructure.tip
		monthParam="${namespacedFieldName}Month"
		monthValue=fieldDateValue?string("MM")?number - 1
		yearParam="${namespacedFieldName}Year"
		yearRangeEnd=fieldDateValue?string("yyyy")?number + 100
		yearRangeStart=fieldDateValue?string("yyyy")?number - 100
		yearValue=fieldDateValue?string("yyyy")?number
	/>

	${fieldStructure.children}
</@>