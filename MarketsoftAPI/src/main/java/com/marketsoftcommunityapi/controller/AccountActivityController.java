package main.java.com.marketsoftcommunityapi.controller;

import com.google.gson.Gson;
import main.java.com.marketsoftcommunityapi.model.Customer;
import main.java.com.marketsoftcommunityapi.model.logging.AccountActivity;
import main.java.com.marketsoftcommunityapi.repository.Loggers.AccountActivityRepo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Aidan Stewart
 * @Year 2019
 * Copyright (c)
 * All rights reserved.
 */
public class AccountActivityController{
        private Subject subject = SecurityUtils.getSubject();
        private AccountActivityRepo repo = new AccountActivityRepo();

        @GetMapping("accountactivity/all")
        public ResponseEntity getAll() {
            subject.checkPermission("accountactivity:display");
            return new ResponseEntity<>(repo.getAll(), HttpStatus.OK);
        }


        @GetMapping("accountactivity/all/whereparams")
        public ResponseEntity getAll(@RequestParam("where") String whereClause, @RequestParam("params") String[] params) {
            subject.checkPermission("accountactivity:display");
            return new ResponseEntity<>(repo.getAll(whereClause, params), HttpStatus.OK);
        }

        @GetMapping("accountactivity/all/where")
        public ResponseEntity getAll(@RequestParam("clause") String whereClause, @RequestParam("param") String param) {
            subject.checkPermission("accountactivity:display");
            return new ResponseEntity<>(repo.getAll(whereClause, param), HttpStatus.OK);
        }


        @GetMapping("/accountactivity")
        public ResponseEntity get(@RequestParam int id) {
            subject.checkPermission("accountactivity:display");
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @DeleteMapping("/accountactivity")
        public ResponseEntity delete(@RequestParam int id){
            subject.checkPermission("accountactivity:delete");
            repo.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }


        @PostMapping("/accountactivity")
        public ResponseEntity post (@RequestParam("accountactivity") String json) {
            subject.checkPermission("accountactivity:add");
            repo.add(new Gson().fromJson(json, AccountActivity.class));
            return new ResponseEntity<>(json , HttpStatus.OK);
        }

        @PutMapping("/accountactivity")
        public ResponseEntity<String> put(@RequestParam("accountactivity") String json)  {
            subject.checkPermission("accountactivity:update");
            repo.update(new Gson().fromJson(json, AccountActivity.class));
            return new ResponseEntity<>(HttpStatus.OK);

        }
}
