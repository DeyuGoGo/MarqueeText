package go.deyu.marqueetextsample

import javax.xml.transform.OutputKeys.METHOD


@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.TYPE,
    AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.FIELD
)
annotation class UsedByReflection(val value: String = "")