

-[Junit 5 with Spring boot 2d](https://howtodoinjava.com/spring-boot2/testing/junit5-with-spring-boot2/)

-[JUnit 5 Assertions Examples](https://howtodoinjava.com/junit5/junit-5-assertions-examples/)

Exclude Junit 4
```$xslt
    <!-- exclude junit 4 -->
    <exclusions>
        <exclusion>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
        </exclusion>
        <exclusion>
            <groupId>org.junit.vintage</groupId>
            <artifactId>junit-vintage-engine</artifactId>
        </exclusion>
    </exclusions>
```
With Junit 5, we do not need @RunWith(SpringRunner.class) anymore. 
Spring tests are executed with @ExtendWith(SpringExtension.class) and @SpringBootTest and the 
other @…Test annotations are already annotated with it.