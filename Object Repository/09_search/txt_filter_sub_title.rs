<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>검색 > 필터 화면 > 서브 타이틀</description>
   <name>txt_filter_sub_title</name>
   <tag></tag>
   <elementGuidId>72f11f4f-52c3-41b7-ae7f-337ae511d4a9</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/subTitleTxt</value>
      <webElementGuid>231b786f-ded7-4cab-99db-4091775c84f8</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>11eae27d-eeba-46ab-a18c-acb818674ed4</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/subTitleTxt' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
