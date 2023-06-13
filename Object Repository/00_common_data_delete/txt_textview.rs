<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>설정 > 애플리케이션</description>
   <name>txt_textview</name>
   <tag></tag>
   <elementGuidId>28986507-cfcb-44b5-a60b-1183e6301eb4</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>android.widget.TextView</value>
      <webElementGuid>b0d73ad9-2f3a-4517-8a74-e39fe99b5fc9</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>0a8b6b2a-3cea-4722-a840-1cd3346fc7ef</webElementGuid>
   </webElementProperties>
   <locator>//*[@class = 'android.widget.TextView' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
