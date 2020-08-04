package tw.com.annotation;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* jdk1.5:自定義註解練習
* 說明:
*	① 註解聲明為 @interface
*	② 內部定義成員，通常使用value表示
*	③ 可以指定成員的默認值，使用default定義
*	④ 如果自定義註解沒有成員，表示是一個標示作用
*
* 如果註解有成員，在使用註解時，須指名成員的值。
* 自定義註解必須配上註解的訊息處理流程(使用反射)才有意義。
* 自定義註解通常都會指名兩個元註解:Retention、Traget
* 
* jdk提供四種元註解(元註解:對現有的註解進行解釋說明的註解)
* 	① Retention:指定所修飾的Annotation的生命週期	SORUCE/CLASS(默認行為)/RUNTIME
* 				只有聲明為RUNTIME生命週期的註解，才能透過反射獲取。
* 	② Traget:用於指定被修飾的Annotation能在哪些程序元素上修飾。
* 	③ Documented:表示所修飾的註解在被javadoc解析時，保留下來。
* 	④ Inherited:被它修飾的Annotation將具有繼承性。
* 
* jdk1.8中註解新特性:可重複註解、註解類型
* 	(一)可重複註解
* 		① 在AnnotactionDemo01A上聲明@Repeatable，成員值為AnnotactionDemo01B.class
* 		② AnnotactionDemo01B的@Inherited、@Retention、@Target等元註解和AnnotactionDemo01A相同
* 	(二)註解類型
* 		① ElementType.TYPE_PARAMETER:表示該註解能寫在類型變數的聲明語句中(如:泛型聲明)
*		② ElementType.TYPE_USE:表示該註解能寫在使用類型的任何與劇中
*/

@Inherited
@Repeatable(AnnotactionDemo01B.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE })
public @interface AnnotactionDemo01A {
	// 定義成員屬性(未使用默認值)
	// String value();

	// 定義成員屬性(使用默認值)
	String value() default "hello";
}
