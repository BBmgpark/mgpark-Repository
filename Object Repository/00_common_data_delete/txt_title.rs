<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>설정 > 애플리케이션 > title</description>
   <name>txt_title</name>
   <tag></tag>
   <elementGuidId>fbd1f6f6-2145-42ff-b83e-3a04f50212b3</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>android:id/title</value>
      <webElementGuid>93e49ba6-20e8-4fd3-9e29-d58908e91fb5</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>39679bc6-9516-4e95-8541-e22c7ae53682</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'android:id/title' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
