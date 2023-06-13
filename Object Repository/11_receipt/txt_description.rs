<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>접수 > 접수 설정 화면 > 설정 옵션</description>
   <name>txt_description</name>
   <tag></tag>
   <elementGuidId>ac623b53-95a8-4a15-a517-a5dcd9f2acd5</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/descriptionTxt</value>
      <webElementGuid>0d465925-b012-4f50-b9da-d60873cf7b5b</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>ae71bd1f-b20f-4efc-8c4f-5ba79f04059e</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/descriptionTxt' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
