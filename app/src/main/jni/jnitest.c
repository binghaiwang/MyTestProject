/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
#include <string.h>
#include <jnitest.h>

JNIEXPORT jstring JNICALL Java_com_test_mytestproject_JniResource_hello
  (JNIEnv* env, jobject thiz){
	char* string = "hello jni!!";
	return (*env)->NewStringUTF(env,string);
}

JNIEXPORT void JNICALL Java_com_test_mytestproject_JniResource_showAddToast
  (JNIEnv* env, jobject thiz,jint x, jint y){
	jclass clazz = (*env)->FindClass(env,"com/jni/jnitest/JniResource");
	jmethodID methodID1 = (*env)->GetMethodID(env,clazz,"add","(II)Ljava/lang/String;");
	jmethodID methodID2 = (*env)->GetMethodID(env,clazz,"printAddResult","(Ljava/lang/String;)V");
	jobject resultObj = (*env)->CallObjectMethod(env,thiz,methodID1,x,y);
	(*env)->CallVoidMethod(env,thiz,methodID2,resultObj);
}

JNIEXPORT void JNICALL Java_com_test_mytestproject_JniResource_showDelToast
  (JNIEnv* env, jobject thiz,jint x , jint y){
	jclass clazz = (*env)->FindClass(env,"com/jni/jnitest/JniResource");
	jmethodID methodID1 = (*env)->GetMethodID(env,clazz,"del","(II)Ljava/lang/String;");
	jmethodID methodID2 = (*env)->GetMethodID(env,clazz,"printDelResult","(Ljava/lang/String;)V");
	jobject resultObj = (*env)->CallObjectMethod(env,thiz,methodID1,x,y);
	(*env)->CallVoidMethod(env,thiz,methodID2,resultObj);
}
