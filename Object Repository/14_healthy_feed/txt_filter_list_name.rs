<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>건강피드 > 보기 필터 > 필터 목록</description>
   <name>txt_filter_list_name</name>
   <tag></tag>
   <elementGuidId>11b728dc-e2c7-49c0-9976-c60d8ad16481</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/nameTxt</value>
      <webElementGuid>ea72a1fd-49d0-4f3b-997d-eb8a85fb7085</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>dcb9cf8a-9016-432a-9a19-c786cb95838c</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/nameTxt' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
