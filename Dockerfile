FROM openjdk:11
COPY target/imagine_interface-0.0.1-SNAPSHOT.jar imagine_interface.jar 
EXPOSE 1111
ENTRYPOINT ["java","-jar","imagine_interface.jar"]