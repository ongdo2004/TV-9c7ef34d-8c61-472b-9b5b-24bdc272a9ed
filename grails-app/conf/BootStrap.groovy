import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        registerMarshaller();
    }

    def destroy = {
    }

    private void registerMarshaller() {

        JSON.registerObjectMarshaller(UUID, { UUID id ->
            return id.toString();
        })
    }
}
