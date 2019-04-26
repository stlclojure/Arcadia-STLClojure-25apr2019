(ns game.core
  (:use arcadia.core))

(defn main-camera []
  (object-named "Main Camera"))

(defn rotate [obj role-key]
  (.. obj transform (Rotate 0 1 0)))

(defn point-camera [p]
  (.. Camera/main transform (LookAt p)))

(comment
  (hook+ (object-named "Main Camera") :update :rotation #'game.core/rotate)
  )

(log "Loaded game.core namespace.")
