<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>병원 상세 > 공통 텍스트</description>
   <name>txt_view</name>
   <tag></tag>
   <elementGuidId>ffdff7e0-31d9-45a3-aa7b-273b2dfdb59e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>android.widget.TextView</value>
      <webElementGuid>e7953800-0ec7-4843-8211-3a1a33c7929f</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>e3bede17-3c3c-4f54-b391-b0cf26183428</webElementGuid>
   </webElementProperties>
   <locator>//*[@class = 'android.widget.TextView' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
