<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>마이페이지 > 개인정보 수정 > 주소 영역</description>
   <name>txt_adress</name>
   <tag></tag>
   <elementGuidId>9865bf0c-d276-4af1-ad2d-90f6ba307ac6</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/tv_description</value>
      <webElementGuid>e9db5e69-6171-4869-b9af-1eb4ed7253a5</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>aee81ead-f3ba-4a5b-80d3-bfc227d75d80</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/tv_description' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
