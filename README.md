# Spring Boot Audit Demo with Envers

### Steps
For audit :

* Add dependency <br/>
```
    <dependency>
        <groupId>org.springframework.data</groupId>
        <artifactId>spring-data-envers</artifactId>
    </dependency>
```
* Add `@Audited` to Entity class
* Extend `RevisionRepository` along with `JpaRepository`
* Enable `@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)`

### Guides
The following screenshots illustrate audit features concretely:

* ![Person Table](/src/main/resources/static/person.PNG?raw=true "Person Table")
* ![Person Audit Table](/src/main/resources/static/person_aud.PNG?raw=true "Person Audit Table")
* revType values 0,1,2 indicate insert,update,delete respectively 
* ![Revision Info Table](/src/main/resources/static/revinfo.PNG?raw=true "Revision")

