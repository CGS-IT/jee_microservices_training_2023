package at.cgsit.jeemicro.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

/**
 * @Author CGS-IT Solutions @2019
 */
@Entity
@Table( name="chat_message")
@NamedQueries({
        @NamedQuery(
                name = "ChatMessageEntity.countAll",
                query = "SELECT count(e) from ChatMessageEntity e"),
        @NamedQuery(
                name = "ChatMessageEntity.findByLikeRoomName",
                query = "SELECT e FROM ChatMessageEntity e WHERE e.chatRoom like :cmRoomName ORDER by e.creationTime DESC"),
})
public class ChatMessageEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="user_name", length= 100, nullable = false)
    private String userName;

    @NotBlank(message="ChatRoom may not be blank")
    @Column(name="chat_room", length= 50, nullable = true)
    private String chatRoom;

    @Column(name="chat_message", length= 250, nullable = false)
    private String chatMessage;

    @Column(name="creation_time", nullable = true)
    private LocalDateTime creationTime;

    private Boolean isImportant;

    @AssertTrue(message = "this chat message is not allowed. because of user name")
    public boolean isChatMessageAllowed() {
        if("chris".equalsIgnoreCase(this.userName)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(String chatRoom) {
        this.chatRoom = chatRoom;
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public Boolean getImportant() {
        return isImportant;
    }

    public void setImportant(Boolean important) {
        isImportant = important;
    }


    @Override
    public String toString() {
        return "ChatMessageEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", chatRoom='" + chatRoom + '\'' +
                ", chatMessage='" + chatMessage + '\'' +
                ", creationTime=" + creationTime +
                ", isImportant=" + isImportant +
                '}';
    }
}