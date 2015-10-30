# jersey-spring-spock-test

I am a typical software developer, who relies on internet for all the help to program, but recently I ran into problem where I wanted to test jersey resources using spock, we had spring DI to inject the beans. Surprisingly I could not find any internet thingy which I can copy paste and carry on with my job, I came up a very simple solution which I though I should share.

Lets identify what were the problems to be solved:

1) Spock test are extended by class Specification and Jersey Test also extends the class JerseyTest, well in java we dont support multiple inheritence, but this problem can be easily solved by delegation, well to our saviour come groovy's delegation mechanism, (Well I am a groovy fan and just a reminder spock is a groovy based DSL for testing).

2) Adding Spock Mocks to build jersery resources and pass it to the Jersey for booting a http container, since my resource were spring managed, so my saviour was ConfigurableListableBeanFactory, this spring factory allows your to inject your own instances of bean into spring application context, again using delegation mechanism, you can allow your test classes to register their own beans.
