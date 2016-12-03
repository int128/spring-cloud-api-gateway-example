package example.gateway

import groovy.transform.Immutable

@Immutable
class TwitterSearch {
    List<Status> statuses

    @Immutable
    static class Status {
        String text
        String created_at
    }
}
