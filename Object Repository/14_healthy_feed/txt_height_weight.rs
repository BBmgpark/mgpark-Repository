<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>건강피드 > 성장관리 > 키/몸무게 &quot;00cm (N백분위)&quot;</description>
   <name>txt_height_weight</name>
   <tag></tag>
   <elementGuidId>29125bd6-354f-499b-8281-e05610afc97c</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/heightAndWeightText</value>
      <webElementGuid>9e8a242a-baf9-401f-b685-5322fffea787</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>contains</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>22f6968c-7ff9-4cda-9e0f-01a9cf756cba</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/heightAndWeightText' and (contains(@text, '${text}') or contains(., '${text}'))]</locator>
   <locatorStrategy>ATTRIBUTES</locatorStrategy>
</MobileElementEntity>
