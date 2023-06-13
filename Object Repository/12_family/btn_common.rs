<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>가족관리 > 공유계정 추가 > [공유받은 초대코드 입력하기]</description>
   <name>btn_common</name>
   <tag></tag>
   <elementGuidId>9c5ac837-7c08-4dab-bf60-52a88abdf411</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/tvCommonButtonView</value>
      <webElementGuid>7797d279-5ae6-4565-ac0a-ae7a31482cde</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>48d069c8-2a4f-403d-a25e-71090b517234</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/tvCommonButtonView' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
