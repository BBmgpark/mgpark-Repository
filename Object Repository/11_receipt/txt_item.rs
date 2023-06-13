<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>접수 > 진료항목</description>
   <name>txt_item</name>
   <tag></tag>
   <elementGuidId>da013e0e-43da-47dd-8ae5-10dc0b5e60a0</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/tvName</value>
      <webElementGuid>65491eaa-6095-4ddf-a619-af942a758abb</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>5edb3614-879f-4aec-8034-4112e1c8cd8a</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/tvName' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
