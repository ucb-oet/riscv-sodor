//**************************************************************************
// RISCV Processor 5-Stage Event Tracing
//--------------------------------------------------------------------------

package sodor.stage5

import chisel3._

import eventtrace.EventTrace

// EventTrace: what the five-stage core records in configs that trace, each instruction from Decode until it retires or
// is killed.
object SodorTrace
{
   // Where an instruction is. Sodor keeps it implicit in its pipeline registers.
   object Stage extends ChiselEnum
   {
      val Decode    = Value
      val Execute   = Value
      val Memory    = Value
      val Writeback = Value
   }

   class Instruction extends EventTrace.ObjectType("instruction")
   {
      val pc    = const(UInt(32.W))
      val bits  = const(UInt(32.W))
      val stage = mutable(Stage())
   }
}
