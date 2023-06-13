<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>진료 대상 선택 > 이름</description>
   <name>txt_name</name>
   <tag></tag>
   <elementGuidId>ed519375-a8e6-44ad-aa2b-31e6f6c54d03</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/nameTxt</value>
      <webElementGuid>1ce6a496-d3e2-4a42-a662-2d1fdf96a983</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>4f80b0a9-0eb6-43e3-8908-0015bf57c70b</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/nameTxt' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
