<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>검색 > 검색결과 > 뱃지</description>
   <name>txt_badge</name>
   <tag></tag>
   <elementGuidId>ad4ba1bc-ed78-4495-8d29-9f1410e9ab84</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/badgeTextView</value>
      <webElementGuid>bab54167-7d48-4a51-9aa8-f81c6aa52483</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>b7f039dc-d6bc-4dd0-a270-09a126ed380c</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/badgeTextView' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
