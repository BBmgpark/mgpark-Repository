<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>가족추가 > 이용약관</description>
   <name>btn_add_use</name>
   <tag></tag>
   <elementGuidId>a5ab8e67-5783-48d8-aa33-aab1cbb5d494</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/cb_title</value>
      <webElementGuid>0b3cff48-dff5-455d-a303-5c5657ceaaa7</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>3154b3bb-963d-4ac0-9fab-82acb2bea110</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/cb_title' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
