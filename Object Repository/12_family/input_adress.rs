<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>가족 관리 > 가족 편집 > [주소 입력하기]</description>
   <name>input_adress</name>
   <tag></tag>
   <elementGuidId>23fd98e7-fbdb-425b-9d9d-ea1b2c221af8</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/tv_address_input</value>
      <webElementGuid>cbad0ce7-f028-4836-8227-329f1370cf43</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>037cb484-9844-4f0d-9ce4-e854ae6faab6</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/tv_address_input' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
