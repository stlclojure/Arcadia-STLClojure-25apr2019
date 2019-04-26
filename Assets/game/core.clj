(ns game.core
  (:use arcadia.core
        arcadia.linear))

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

(defn slide [obj]
  (.. obj transform ()))

(comment
  ;; Hit play AND THEN connect to the repl
  (require 'game.core)
  (use 'arcadia.core)
  (hook+ (main-camera) :update :rotation #'game.core/rotate)
  (hook+ (main-camera) :update :rotation #'game.core/rotate-other-way)
  (hook+ (main-camera) :update :rotation #'game.core/rotate-both-ways)
  (hook+ (main-camera) :update :rotation #'game.core/unrotate)
  (create-primitive :sphere)
  (create-primitive :sphere "Imma Ball")
  (create-primitive :cube "Imma Box")
  (hook+ (object-named "Imma Box")
         :update :rotation #'game.core/rotate-both-ways
         )
  )

(log "Loaded game.core namespace.")
