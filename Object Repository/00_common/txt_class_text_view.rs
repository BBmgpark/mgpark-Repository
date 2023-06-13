<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>공통 텍스트</description>
   <name>txt_class_text_view</name>
   <tag></tag>
   <elementGuidId>7c250a6a-6e7b-4056-8240-88ed42dc2af2</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>android.widget.TextView</value>
      <webElementGuid>b16c9f2c-ea99-42d9-9c17-28a7717b459b</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>bd3e263a-24de-41be-ab46-db1f8b8eeb53</webElementGuid>
   </webElementProperties>
   <locator>//*[@class = 'android.widget.TextView' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
