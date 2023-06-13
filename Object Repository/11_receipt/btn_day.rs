<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>예약 > 날짜선택 > day</description>
   <name>btn_day</name>
   <tag></tag>
   <elementGuidId>df6437ed-09f5-48c5-bb22-f524410f297b</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/dayTxt</value>
      <webElementGuid>f5296ceb-0c1d-471b-b996-b2b6bd4a213c</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>ba480e0e-bd65-4d51-af0b-e6782e8c2bda</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/dayTxt' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
