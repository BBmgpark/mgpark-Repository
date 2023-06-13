<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>홈 > 병원 추천 영역 > 병원 이름</description>
   <name>txt_recommend_hospital_name</name>
   <tag></tag>
   <elementGuidId>8d57a5df-f418-41c4-b95a-30b23485ad52</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/tv_title</value>
      <webElementGuid>76caf514-70fa-4993-aea5-73612336469d</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>contains</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>[TEST]</value>
      <webElementGuid>c95328c5-30f2-4f4c-864a-7236b4da85b8</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/tv_title' and (contains(@text, '[TEST]') or contains(., '[TEST]'))]</locator>
   <locatorStrategy>ATTRIBUTES</locatorStrategy>
</MobileElementEntity>
