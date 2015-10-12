var express = require('express');
var router = express.Router();

var mongoose = require('mongoose');
var person = require('../models/Person.js');


router.get('/', function(req, res, next) {
  person.find(function (err, persons) {
    if (err) return next(err);
    res.json(persons);
  });
});

/* GET /todos listing. */
router.get('/:id', function(req, res, next) {
  person.findById(req.params.id,function (err, post) {
    if (err) return next(err);
    res.json(post);
  });
});

router.post('/', function(req, res, next) {
  Todo.create(req.body, function (err, post) {
    if (err) return next(err);
    res.json(post);
  });
});

module.exports = router;