<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>검색 > 주소 이름</description>
   <name>txt_search_adress_name</name>
   <tag></tag>
   <elementGuidId>bfaf4ec8-300c-4c22-8590-f8fd956e58f3</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/commonBtnTitle</value>
      <webElementGuid>5a8c6716-f8d6-48ac-ba01-4079e2782a40</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>5d8ec997-ebb9-45f9-af72-d096fca4b815</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/commonBtnTitle' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
