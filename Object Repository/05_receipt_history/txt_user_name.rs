<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>진료내역 > 목록 > 본인 이름</description>
   <name>txt_user_name</name>
   <tag></tag>
   <elementGuidId>4f120c17-881a-400f-8008-382785f0ddda</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/tvUserName</value>
      <webElementGuid>4399e512-eed9-4ee0-b115-6b58092f5bcb</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>1a1101b5-12c1-4a74-bcec-96aea2a1e1d8</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/tvUserName' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
