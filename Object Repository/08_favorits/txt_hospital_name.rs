<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>찜한 목록 > 병원명 영역</description>
   <name>txt_hospital_name</name>
   <tag></tag>
   <elementGuidId>01fb2d14-baee-4306-9a42-b3c99cae3997</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/tv_favorite_title</value>
      <webElementGuid>5569bac5-62f4-411e-8865-f65a751d39d1</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>97fa1ca6-6148-4113-a3f2-c5e4354888a6</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/tv_favorite_title' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
