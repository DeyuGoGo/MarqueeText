@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
public @interface UsedByReflection {

    String value();
}
