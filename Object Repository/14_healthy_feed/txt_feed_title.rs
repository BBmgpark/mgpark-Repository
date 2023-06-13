<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>건강피드 > 피드 타이틀</description>
   <name>txt_feed_title</name>
   <tag></tag>
   <elementGuidId>fdb57480-2bb0-429f-b41d-5199189290ad</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/feedTitle</value>
      <webElementGuid>012c1618-40e0-49bc-8141-62d4f2fb1430</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>9060b6ea-4e09-4353-b59e-15b99f64a550</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/feedTitle' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
