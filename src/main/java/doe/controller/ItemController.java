package doe.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import doe.model.Item;
import doe.repository.ItemRepository;

@Controller    
@RequestMapping(path="item") 
public class ItemController {
	@Autowired
	private ItemRepository itemRepository;

    public static final Logger logger = LoggerFactory.getLogger(ItemController.class);
      
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> buscarTodos() {
    	List<Item> itens = itemRepository.findAll();
        if (itens.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Item>>(itens, HttpStatus.OK);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable("id") long id) {
        Item item = itemRepository.findOne(id);
        if (item == null) {
            return new ResponseEntity(new CustomErrorType("Não encontrado!"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> cadastrar(@RequestBody Item item, UriComponentsBuilder ucBuilder) {
        item = itemRepository.save(item);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/item/{id}").buildAndExpand(item.getIdItem()).toUri());

        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizar(@PathVariable("id") long id, @RequestBody Item item) {
        Item currentItem = itemRepository.findOne(id);
 
        if (currentItem == null) {
            return new ResponseEntity(new CustomErrorType("Não encontrado!"), HttpStatus.NOT_FOUND);
        }
 
        currentItem.setObservacao(item.getObservacao());
        currentItem.setQualidade(item.getQualidade());
        
        itemRepository.save(currentItem);
        return new ResponseEntity<Item>(currentItem, HttpStatus.OK);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletar(@PathVariable("id") long id) {
        Item item = itemRepository.findOne(id);
        if (item == null) {
            return new ResponseEntity(new CustomErrorType("Não encontrado!"), HttpStatus.NOT_FOUND);
        }
        itemRepository.delete(id);
        return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
    } 
}
