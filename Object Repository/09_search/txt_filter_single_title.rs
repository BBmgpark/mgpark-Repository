<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>검색 > 필터 화면 > 개별 타이틀</description>
   <name>txt_filter_single_title</name>
   <tag></tag>
   <elementGuidId>0bc6fc83-48d2-4f9c-8717-02f6c54112a7</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/singleFilterTitle</value>
      <webElementGuid>1d2a1ca7-7078-4ce7-8a59-1bad7f4c75a7</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>98f8fe38-875b-40b4-a205-c73358e9c0b1</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/singleFilterTitle' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
