<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>접수 > 접수 설정</description>
   <name>txt_setting</name>
   <tag></tag>
   <elementGuidId>67e5a05d-fb05-4379-9956-8d7fcd1801b2</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/titleTxt</value>
      <webElementGuid>050f130e-664f-4a93-b75e-0c1b17652ef4</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>a617c838-0460-4463-a387-dbbf80c2122e</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/titleTxt' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
