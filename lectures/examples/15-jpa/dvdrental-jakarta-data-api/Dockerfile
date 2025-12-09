FROM quay.io/wildfly/wildfly:38.0.1.Final

# This Dockerfile is intentionally minimal. We use the official WildFly image
# and rely on docker-compose to mount the built WAR into the deployments folder.
# If you want to add management users or modules at build time, extend this file
# to copy scripts or modules into the image.

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
