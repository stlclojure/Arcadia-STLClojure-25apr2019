(ns game.core
  (:use arcadia.core))

(defn main-camera []
  (object-named "Main Camera"))

(defn rotate [obj role-key]
  (.. obj transform (Rotate 0 1 0)))

(defn rotate-other-way [obj role-key]
  (.. obj transform (Rotate 0 0 1)))

(defn rotate-other-way [obj role-key]
  (.. obj transform (Rotate 0 0 1)))

(defn rotate-both-ways [obj role-key]
  (.. obj transform (Rotate 0 1 1)))

(defn unrotate [obj role-key]
  (.. obj transform (Rotate 0 0 0)))

(defn point-camera [p]
  (.. Camera/main transform (LookAt p)))

(comment
  ;; Hit play AND THEN connect to the repl
  (require 'game.core)
  (use 'arcadia.core)
  (hook+ (main-camera) :update :rotation #'game.core/rotate)
  (hook+ (main-camera) :update :rotation #'game.core/rotate-other-way)
  (hook+ (main-camera) :update :rotation #'game.core/rotate-both-ways)
  (hook+ (main-camera) :update :rotation #'game.core/unrotate)
  )

(log "Loaded game.core namespace.")
