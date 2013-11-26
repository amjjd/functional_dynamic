package com.amjjd

import org.scalatest.concurrent.Interruptor

package object functional_dynamic {
  private[functional_dynamic] val stop: Interruptor = new Interruptor {
    def apply(testThread: Thread) {
      testThread.stop()
    }
  }
}
