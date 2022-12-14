package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public record PostComment(Account author, LocalDateTime timeCommented, String body) implements Serializable {
}
