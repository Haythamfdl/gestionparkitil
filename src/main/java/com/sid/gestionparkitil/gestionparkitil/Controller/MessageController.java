package com.sid.gestionparkitil.gestionparkitil.Controller;

import com.sid.gestionparkitil.gestionparkitil.Dto.MessageDto;
import com.sid.gestionparkitil.gestionparkitil.Model.Message;
import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;
import com.sid.gestionparkitil.gestionparkitil.Repo.MessageRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class MessageController {
    private MessageRepo messageRepo;

    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping("/messages/{id}")
    public Optional<Message> getMessage(@PathVariable(name = "id") Long id) {
        return messageRepo.findById(id);
    }

    @GetMapping("/messages/user/{id}")
    public List<Message> getAllMessages(@PathVariable(name = "id") Long id) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIduser(id);
        return messageRepo.findAllByRecepteurAndIsdeletedOrderByDateenvoieDesc(utilisateur, false);
    }

    @GetMapping("/messages/user/{id}/{ouv}")
    public List<Message> getAllMessagesOuvert(@PathVariable(name = "id") Long id, @PathVariable(name = "ouv") Boolean ouv) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIduser(id);
        return messageRepo.findAllByRecepteurAndOuvertAndIsdeletedOrderByDateenvoieDesc(utilisateur, ouv, false);
    }

    @GetMapping("/messages/count/{id}/{ouv}")
    public Long getAllMessagesOuvertCount(@PathVariable(name = "id") Long id, @PathVariable(name = "ouv") Boolean ouv) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIduser(id);
        return messageRepo.findAllByRecepteurAndOuvertAndIsdeletedOrderByDateenvoieDesc(utilisateur, ouv, false).stream().count();
    }

    @PostMapping(value = "/messages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMessage(@RequestBody MessageDto messagedto) {
        messageRepo.save(attribut(messagedto));
    }

    @PutMapping(value = "/messages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateMessage(@RequestBody MessageDto messagedto) {
        messageRepo.save(attribut(messagedto));
    }

    //Permet d'attribuer les valeurs de l'objet Dto a l'objet Entit??
    private Message attribut(MessageDto messagedto){
        Message message = new Message();
        message.setIdmess(messagedto.getIdmess());
        message.setSujet(messagedto.getSujet());
        message.setMessage(messagedto.getMessage());
        message.setOuvert(messagedto.getOuvert());
        message.setEnvoyeur(messagedto.getEnvoyeur());
        message.setRecepteur(messagedto.getRecepteur());
        message.setDateenvoie(messagedto.getDateenvoie());
        message.setIsdeleted(messagedto.getIsdeleted());
        return message;
    }
}
