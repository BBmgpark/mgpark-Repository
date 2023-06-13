<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>병원상세 > [접수/예약]</description>
   <name>btn_right</name>
   <tag></tag>
   <elementGuidId>7c63919f-5923-4e9a-801a-4139a0edd743</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup:id/tv_right_button</value>
      <webElementGuid>dd00dfe0-c98c-4231-8690-dd65d6ea6bce</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>1d2da71d-996c-4d5b-923d-9a964c2912fb</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup:id/tv_right_button' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
