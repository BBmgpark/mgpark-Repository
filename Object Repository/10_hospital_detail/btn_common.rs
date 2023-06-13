<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>공통 버튼
android.widget.Button</description>
   <name>btn_common</name>
   <tag></tag>
   <elementGuidId>7dfa6b07-56d8-48d7-b3a1-637e7ebf83f3</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>android.widget.Button</value>
      <webElementGuid>6b54dabe-7524-4bf8-aa7d-193f2c2b3f05</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>679b59d0-f0a7-4fcd-92ac-e84f845bc5db</webElementGuid>
   </webElementProperties>
   <locator>//*[@class = 'android.widget.Button' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
