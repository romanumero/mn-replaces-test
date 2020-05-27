package demo

import io.micronaut.context.annotation.Replaces

@Replaces(MyService.class)
@Singleton
class MockMyService implements MyService {
    @Override
    String doStuff() {
        println("FROM_MOCK")
        return "FROM_MOCK"
    }
}
