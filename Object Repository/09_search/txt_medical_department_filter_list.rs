<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>검색 > 진료과목 바텀시트 > 리스트</description>
   <name>txt_medical_department_filter_list</name>
   <tag></tag>
   <elementGuidId>13053b08-49b9-4905-a504-af226495a434</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/tv_category_text</value>
      <webElementGuid>09105b68-7fa1-43c3-9b08-2376ab1a56bc</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>186d3892-39f1-470f-8018-9db71fd24361</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/tv_category_text' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
