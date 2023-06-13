<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>병원상세 > [{좌측}] 버튼</description>
   <name>btn_left</name>
   <tag></tag>
   <elementGuidId>975036fd-db5f-467c-b5c8-cfdfc6f5535d</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/tv_left_button</value>
      <webElementGuid>2d78853d-f7db-4d1e-89ed-ec518d7988cd</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>37f94a56-65b0-4268-a1ce-b5584bde9136</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/tv_left_button' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
