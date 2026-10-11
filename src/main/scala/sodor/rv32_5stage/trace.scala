//**************************************************************************
// RISCV Processor 5-Stage Event Tracing Schema
//--------------------------------------------------------------------------

package sodor.stage5

import chisel3._

import eventtrace.EventTrace

// The stage an instruction occupies. Sodor keeps it implicit in its pipeline registers.
object Stage extends ChiselEnum
{
   val Decode, Execute, Memory, Writeback = Value
}

// One dynamic instruction, from entering Decode until it retires or is squashed.
class Instruction extends EventTrace.ObjectType("instruction")
{
   val pc    = const(UInt(32.W))
   val bits  = const(UInt(32.W))
   val stage = mutable(Stage())
}
object Instruction extends EventTrace.Schema(new Instruction)
